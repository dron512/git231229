import axios from 'axios'
export default {
  data() {
    return {
      view: 1,
      key: '',
      auth: {
        token: '',
        header: {
          algorithm: '',
          type: ''
        },
        payload: {
          no: 0,
          name: '',
        }
      }
    }
  },
  methods: {
    authorize() {
      this.auth.token = ''
      if(this.key == '') return
      const params = {name: this.key};
      axios.get('http://localhost:8080/auth/authorize', {params})
        .then((res) => {
          if(res.data.state) {
            this.auth.token = res.data.token
            this.view = 2
          }
        })
        .catch((err) => console.log(err))
    },
    verification() {
      if(this.auth.token == '') return
      //const params = {token: this.auth.token, key: this.key};

      const setInterceptors = (instance, token) => {
        instance.interceptors.request.use(
          (config) => {
            config.headers.Authorization = token
            return config;
          },
          (error) => {return Promise.reject(error)}
        )
        return instance
      }

      const useAxios = (token) => {
        const instance = axios.create({baseURL: ''})
        return setInterceptors(instance, token)
      }

      useAxios(this.auth.token).post('http://localhost:8080/auth/verification')
        .then((res) => {
          console.log(res)
          if(res.data.state) {
            this.auth.header = res.data.header
            this.auth.payload = res.data.payload
          } else {
            alert("token 유효 시간이 지났습니다.")
            this.clean()
          }
        })
        .catch((err) => console.log(err))
    },
    clean() {
      this.auth = {
        token: '',
        header: {algorithm: '',type: ''},
        payload: {name: ''}
      }
      this.key = ''
      this.view = 1
    }
  },
}
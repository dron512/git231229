import { useState } from 'react';
import { Keyboard, KeyboardAvoidingView, Pressable, Text, TextInput, TouchableOpacity, View } from 'react-native';

const Home = () => {

    const [number,setNumber] = useState('1000');

    const [lotto,setLotto] = useState({
        "totSellamnt": 118628811000,
        "returnValue": "success",
        "drwNoDate": "2022-01-29",
        "firstWinamnt": 1246819620,
        "drwtNo6": 42,
        "drwtNo4": 22,
        "firstPrzwnerCo": 22,
        "drwtNo5": 32,
        "bnusNo": 39,
        "firstAccumamnt": 27430031640,
        "drwNo": 1000,
        "drwtNo2": 8,
        "drwtNo3": 19,
        "drwtNo1": 2
      });

    const doA = ()=>{
        fetch("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo="+number)
        .then(response => response.json())
        .then(response => {
            setLotto(response);
            Keyboard.dismiss();
        })
    }

    return (
        <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
            <Pressable onPress={()=>Keyboard.dismiss()}>
                <View style={{alignItems:"center",marginVertical:40}}>
                    <Text style={{fontSize:50}}>1000회 당첨결과</Text>
                    <Text style={{fontSize:30}}>{lotto.drwNoDate} 추첨</Text>
                </View>
                <View style={{flexDirection:"row",marginTop:15}}>
                    <Text style={{backgroundColor:"#09f",margin:10,fontSize:15,padding:10,borderRadius:25,width:40,textAlign:"center"}}>{lotto.drwtNo1}</Text>
                    <Text style={{backgroundColor:"#9f4",margin:10,fontSize:15,padding:10,borderRadius:25,width:40,textAlign:"center"}}>{lotto.drwtNo2}</Text>
                    <Text style={{backgroundColor:"#fe3",margin:10,fontSize:15,padding:10,borderRadius:25,width:40,textAlign:"center"}}>{lotto.drwtNo3}</Text>
                    <Text style={{backgroundColor:"#ce3",margin:10,fontSize:15,padding:10,borderRadius:25,width:40,textAlign:"center"}}>{lotto.drwtNo4}</Text>
                    <Text style={{backgroundColor:"#f29",margin:10,fontSize:15,padding:10,borderRadius:25,width:40,textAlign:"center"}}>{lotto.drwtNo5}</Text>
                    <Text style={{backgroundColor:"#fc3",margin:10,fontSize:15,padding:10,borderRadius:25,width:40,textAlign:"center"}}>{lotto.drwtNo6}</Text>
                </View>
                <View style={{flexDirection:"row",marginBottom:60}}>
                    <Text style={{fontSize:20,marginTop:3,marginHorizontal:15}}>보너스 번호 + </Text>
                    <Text style={{backgroundColor:"#fc3",fontSize:15,padding:10,borderRadius:25,width:40,textAlign:"center"}}>{lotto.bnusNo}</Text>
                </View>
                <View>
                    <Text>테스트입니다.</Text>
                </View>
            </Pressable>
            <KeyboardAvoidingView style={{marginBottom:60}}>
                <View style={{flexDirection:"row",marginBottom:15}}>
                    <TextInput 
                            value={number}
                            keyboardType='numeric'
                            onChangeText={text=>setNumber(text)}
                            style={{
                            backgroundColor:"#fc3",
                            fontSize:20,
                            marginHorizontal:15,
                            padding:10,
                            borderRadius:5,
                            width:150,
                            textAlign:"right"
                            }}/>
                    <Text style={{fontSize:30,marginRight:10}}>회차</Text>
                    <TouchableOpacity 
                        style={{
                            border:"1px solid black", 
                            backgroundColor:"#063",
                            borderRadius:20,
                            justifyContent:"center",
                            alignItems:"center",
                            padding:2
                    }}
                        onPress={doA}
                    >
                        <Text style={{color:"#cfcfcf",fontSize:25,paddingHorizontal:30}}>조회</Text>
                    </TouchableOpacity>
                </View>
            </KeyboardAvoidingView>
        </View>
    );
}

export default Home;
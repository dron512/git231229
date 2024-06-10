import React, { useEffect, useState } from 'react';
import { SERVER_URL } from '../../api/config';
import jwtAxios from '../../util/jwtUtil';
import { useNavigate } from 'react-router';

const RecentSearches = ({ display }) => {
  const [recentSearches, setRecentSearches] = useState([]);
  const navigate = useNavigate();
  const handleClickSearch = (searchText) => {
    navigate('/product/list?search=' + searchText)
  }
  useEffect(() => {
    jwtAxios.get(`${SERVER_URL}/main/recent`)
      .then((response) => {
        setRecentSearches(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [display]);

  // Array of recent searches

  const divStyle = {
    display,
    backgroundColor: "white",
    width: "600px",
    marginLeft: "330px",
    borderRadius: "1rem"
  };

  return (
    <div style={divStyle}>
      <div style={{
        marginLeft: "-440px",
        // backgroundColor: "red",
        textAlign: "left"
      }}>
        {recentSearches.map((searchTerm, index) => (
          <div
            style={{
              paddingLeft: "450px",
              cursor: "pointer"
            }}
            key={index}>
            <h3 style={{
              fontSize: '2rem',
              lineHeight: "4rem",
            }}
              onClick={() => { handleClickSearch(searchTerm.searchcontents) }}
            >{searchTerm.searchcontents}</h3>
          </div>
        ))}
      </div>
    </div>
  );
};

export default RecentSearches;
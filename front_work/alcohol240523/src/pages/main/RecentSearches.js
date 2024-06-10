import React from 'react';

const RecentSearches = ({ display }) => {
  // Array of recent searches
  const recentSearches = ['Search Term 1',
    'Search Term 2',
    'Search Term 3',
    'Search Term 4',
    'Search Term 5',
  ];
  console.log(display);
  const divStyle = {
    display,
    backgroundColor: "white",
    width: "600px",
    marginLeft: "330px",
    borderRadius: "1rem"
    // paddingLeft: "200px"
  };
  console.log("divStyle :", divStyle);

  return (
    <div style={divStyle}>
      <div style={{
        fontSize: "2.5rem",
        marginLeft: "-400px",
        marginTop: "1rem"
      }}>최근 검색어</div>
      <ul style={{
        marginLeft: "-440px",
      }}>
        {recentSearches.map((searchTerm, index) => (
          <li key={index} style={{ fontSize: '2rem', lineHeight: "4rem" }}>{searchTerm}</li>
        ))}
      </ul>
    </div>
  );
};

export default RecentSearches;
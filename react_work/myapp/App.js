import { StatusBar } from 'expo-status-bar';
import { useState, useEffect } from 'react';
import { Button, Image, Pressable, StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import HeaderComponent from './components/HeaderComponent';
import * as Font from "expo-font";

import { frendProfiles, myProfile } from './src/data';
import Profile from './components/Profile';


export default function App() {
  const [isFont, setIsFont] = useState(false);

  useEffect(() => {
    Font.loadAsync({
      Jua: require("./assets/fonts/BMJUA_ttf.ttf")
    })
    setIsFont(true);
  }, [])

  const [aa, setAA] = useState("thisisa");
  const doA = () => {
    fetch("http://localhost:3000/api/v1/test")
      .then(response => response.json())
      .then(data => console.log(data))
  }
  const doB = () => {
    if (aa === "bb")
      setAA("aa");
    else
      setAA("bb");
  }

  return (
    <SafeAreaView style={styles.container}>
      <HeaderComponent />
      <View style={{ height: 15 }}></View>
      <Profile style={{flex:1}} name={myProfile.name} uri={myProfile.uri} introduction={myProfile.introduction} />
      <View style={{ height: 5 }}></View>
      <View style={{ height: 0.5,backgroundColor:"#ccc" }}></View>
      <View style={{ height: 5 }}></View>
      <Text style={{ fontFamily: "Jua" }}>Open up App.js to start working on your app!</Text>
      <Text>Test</Text>
      <Text>alksdcjfnaksdfjcnaksdcfjn</Text>
      <View style={{ flexDirection: "row" }}>
      </View>
      <StatusBar style="auto" />
      <View>
        <Text>{aa}</Text>
        <Button title="Press me" onPress={doB} />
      </View>
      <Pressable onPress={doA}>
        <Text>Press me</Text>
      </Pressable>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    paddingHorizontal: 15,
    // alignItems: 'center',
  },
});

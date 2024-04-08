import { Button, FlatList, Image, Pressable, StatusBar, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import HeaderComponent from './components/HeaderComponent';
import Profile from './components/Profile';
import { friendProfiles, myProfile } from './src/data';
import { useState } from 'react';

export default ({doA,doB,doC}) => {
    console.log(friendProfiles);
    return (
        <View style={{ flex: 1, paddingHorizontal: 15 }}>
            <HeaderComponent />
            <FlatList
                data={board}
                renderItem={
                    ({ item }) => (
                        <Profile name={item.title} introduction={item.content} />
                    )
                }
            >
            </FlatList>
            <Button title="View 가져오기" onPress={doC} />
            <View>
                <Text>{content}</Text>
            </View>
            <Profile name={myProfile.name} uri={myProfile.uri} introduction={myProfile.introduction} />
            <View style={{ height: 0.5, backgroundColor: "#ccc" }}></View>
            <View style={{ height: 5 }}></View>
            <View style={{ flexDirection: "row", justifyContent: "space-between",width:"100%",backgroundColor:"yellow" }}>
                <TouchableOpacity style={{ flex:1  }} onPress={doA}>
                    <Text style={{backgroundColor:"#5f5f5f",color:"#fff"}}>DOA바꾸기(Hello-World)</Text>
                </TouchableOpacity>
            </View>
            <Text style={{ fontFamily: "Roboto" }}>Open up App.js to start working on your app!</Text>
            <Text>Test</Text>
            <Text>alksdcjfnaksdfjcnaksdcfjn</Text>
            <View style={{ flexDirection: "row" }}>
            </View>
            <View>
                <Text>{aa}</Text>
                <Button title="Press me" onPress={doB} />
            </View>
            <Pressable onPress={doA}>
                <Text>Press me</Text>
            </Pressable>
            <FlatList
                data={friendProfiles}
                renderItem={
                    ({ item }) => (
                        <Profile name={item.name} uri={item.uri} introduction={item.introduction} />
                    )
                }
            >
            </FlatList>
        </View>
    );
}
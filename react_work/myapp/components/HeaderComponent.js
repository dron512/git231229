import { Button, Image, Pressable, StyleSheet, Text, View } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import * as Font from "expo-font";
import { useEffect, useState } from 'react';

export default ()=>{
    const [isFont,setIsFont] = useState(false);

    useEffect(()=>{
        Font.loadAsync({
            Jua: require("../assets/fonts/BMJUA_ttf.ttf")
        })
        setIsFont(true);
    },[])
    return (
        <View>
            <Text style={{padding:15,fontSize:30,fontFamily:"Jua"}}>Header</Text>
            <View style={{flexDirection:"row", justifyContent:"space-between",width:"100%"}}>
                <Image source={require('../assets/icon.png')} style={{width:50, height:50}} />
                <View style={{flexDirection:"row"}}>
                    <Ionicons name="accessibility-outline" size={24} color="black" />
                    <Ionicons name="accessibility-outline" size={24} color="black" />
                    <Ionicons name="accessibility-outline" size={24} color="black" />
                    <Ionicons name="accessibility-outline" size={24} color="black" />
                </View>
            </View>
        </View>
    )
}
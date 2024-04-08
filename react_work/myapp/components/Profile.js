import { Image, Text, View } from "react-native";

export default ({ name, uri, introduction }) => {
    return (
        <View>
            <View style={{ height: 15 }}></View>
            <View style={{ flexDirection:"row" , alignItems:"center"}}>
                <Image style={{ width: 30, height: 30, borderRadius:20 }} source={{ uri }} />
                <View style={{marginLeft:15}}>
                    <Text>{name}</Text>
                    <Text>{introduction}</Text>
                </View>
            </View>
            <View style={{ height: 5 }}></View>
        </View>
    );

}
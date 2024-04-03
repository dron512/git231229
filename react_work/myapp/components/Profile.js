import { Image, Text, View } from "react-native";

export default ({ name, uri, introduction }) => {
    return (
        <View style={{ flexDirection:"row" , alignItems:"center"}}>
            <Image style={{ width: 30, height: 30 }} source={{ uri }} />
            <View style={{marginLeft:15}}>
                <Text>{name}</Text>
                <Text>{introduction}</Text>
            </View>
        </View>
    );

}
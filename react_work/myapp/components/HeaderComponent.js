import { Image, Text, TouchableOpacity, View } from 'react-native';
import { Ionicons } from '@expo/vector-icons';

export default () => {
    return (
        <View>
            <Text style={{ padding: 15, fontSize: 30 }}>Header</Text>
            <View style={{ flexDirection: "row", justifyContent: "space-between", width: "100%" }}>
                <Image source={require('../assets/icon.png')} style={{ width: 50, height: 50 }} />
                <View style={{ flexDirection: "row" }}>
                    <TouchableOpacity>
                        <Ionicons name="accessibility-outline" size={24} color="black" />
                    </TouchableOpacity>
                    <TouchableOpacity>
                        <Ionicons name="accessibility-outline" size={24} color="black" />
                    </TouchableOpacity>
                    <TouchableOpacity>
                        <Ionicons name="accessibility-outline" size={24} color="black" />
                    </TouchableOpacity>
                </View>
            </View>
        </View>
    )
}
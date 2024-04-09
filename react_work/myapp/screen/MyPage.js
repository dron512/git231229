import { Text, View } from 'react-native';
import { Fontisto, SimpleLineIcons ,MaterialCommunityIcons  } from '@expo/vector-icons';

const MyPage = () => {
    return (
        <View style={{ flex: 1, alignItems: 'center' }}>
            <View style={{
                width: '100%',
                backgroundColor: '#fff',
                flexDirection: 'row',
                justifyContent: 'flex-end',
            }}>
                <View style={{padding:10}}>
                    <Fontisto name="bell" size={24} color="black" />
                </View>
                <View style={{padding:10}}>
                    <SimpleLineIcons name="settings" size={24} color="black" />
                </View>
            </View>
            <Text>MyPage!</Text>
        </View>
    );
}

export default MyPage;
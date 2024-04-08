import { Button, FlatList, Image, Pressable, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import Menu01 from './Menu01';
import {doA,doB,doC} from './src/use-my';

export default function App() {
  return (
    <SafeAreaView style={{ flex: 1 }}>
      <Menu01 doA={doA} doB={doB} doC={doC} />
      <View style={{
        backgroundColor: "#2b2b2b",
        flexDirection: "row",
        justifyContent: "space-between",
        padding: 15,
      }}>
        <TouchableOpacity style={{ justifyContent: "center", alignItems: "center" }}>
          <Ionicons name="bag-outline" size={24} color="#fff" />
        </TouchableOpacity>
        <TouchableOpacity style={{ justifyContent: "center", alignItems: "center" }}>
          <Ionicons name="bag-outline" size={24} color="#fff" />
        </TouchableOpacity>
        <TouchableOpacity style={{ justifyContent: "center", alignItems: "center" }}>
          <Ionicons name="bag-outline" size={24} color="#fff" />
        </TouchableOpacity>
        <TouchableOpacity style={{ justifyContent: "center", alignItems: "center" }}>
          <Ionicons name="bag-outline" size={24} color="#fff" />
        </TouchableOpacity>
      </View>
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

import * as React from 'react';
import { Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { AntDesign , Entypo , MaterialCommunityIcons, Ionicons , FontAwesome6 } from '@expo/vector-icons';
import Home from './screen/Home';
import Goods from './screen/Goods';
import Board from './screen/Board';
import MyPage from './screen/MyPage';
import Order from './screen/Order';
import { SafeAreaView } from 'react-native-safe-area-context';

const Tab = createBottomTabNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <SafeAreaView>
        <View style={{padding:10}}>
          <MaterialCommunityIcons name="coffee-outline" size={50} color="black" />
        </View>
      </SafeAreaView>
      <Tab.Navigator screenOptions={({ route }) => ({
          tabBarIcon: ({ focused, color, size }) => {
            let iconName;
            if (route.name === 'Home') {
              if( iconName = focused ){
                return <Entypo name="home" size={24} color='#063' />;
              }
              else{
                return <AntDesign name="home" size={24} />;
              }
            } else if (route.name === 'Goods') {
              if( iconName = focused ){
                return <FontAwesome6 name="goodreads" size={24} color="#063" />;
              }
              else{
                return <FontAwesome6 name="goodreads-g" size={24} />;
              }
            } else if (route.name === 'Board') {
              if( iconName = focused ){
                return <Entypo name="home" size={24} color='#063' />;
              }
              else{
                return <AntDesign name="home" size={24} />;
              }
            } else if (route.name === 'Order') {
              if( iconName = focused ){
                return <Ionicons name="star" size={24} color="#063" />;
              }
              else{
                return <Ionicons name="star-outline" size={24} />;
              }
            } else if (route.name === 'MyPage') {
              if( iconName = focused ){
                return <MaterialCommunityIcons name="account-cog" size={24} color="#063"/>;
              }
              else{
                return <MaterialCommunityIcons name="account-cog-outline" size={24} color="black" />;
              }
            }
          },
          tabBarActiveTintColor: '#063',
          tabBarInactiveTintColor: '#999',
        })}
      >
        <Tab.Screen name="Home" component={Home} />
        <Tab.Screen name="Goods" component={Goods} />
        <Tab.Screen name="Board" component={Board} />
        <Tab.Screen name="Order" component={Order} />
        <Tab.Screen name="MyPage" component={MyPage} />
      </Tab.Navigator>
    </NavigationContainer>
  );
}
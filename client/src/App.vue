<template>
  <v-app class="red lighten-1" >
    <v-app-bar app class="red darken-3">
      <v-toolbar-title class="headline text-uppercase">
        <span>Public Relation System</span>
        <span class="font-weight-light">: Report system</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
       <!-- <v-card-actions>
        <v-btn text tile to="/reported">ดูคำร้องทุกข์</v-btn>
        <v-btn text tile to="/">ส่งคำร้องทุกข์</v-btn>           
      </v-card-actions>  -->
    </v-app-bar>
    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>
<script>
export default {
  name: 'App',
  data: () => ({
    //
  }),
};
</script>

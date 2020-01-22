<template>
<v-app>
  <v-card>
  <v-container>   
    <v-flex>
      <v-flex xs12>
                    <v-img
                            :src="require('../assets/tumblr_mb4ffswsfh1reoa3zo1_500.gif')"
                            class="my-1"
                            contain
                            height="200"
                    ></v-img>
      </v-flex>
    </v-flex> 
            <v-card-title>คำร้องทุกข์ 
              <div class="flex-grow-1" ></div>
      <v-text-field
        v-model="search"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
            </v-card-title>
                <v-card-text>
                    <v-data-table
                    :headers="headers"
                    :items="Reported"
                    item-key="id"
                    :search="search"
                    
                    class="elevation-1"
                    ></v-data-table>
                </v-card-text>   
  </v-container>
  </v-card>
</v-app>
</template>

<script>
import ReportController from "../controller/ReportController";
export default {
   data: () => ({
       search: '',
       Reported:[],
       headers: [
      {
        text: "ลำดับ",
        value: "id"
      },
      {
        text: "ประเภท",
        value: "repType"
      },
      {
        text: "ส่งโดย",
        value: "member"
      },
      {
        text: "หัวเรื่อง",
        value: "title"
      },
      {
        text: "รายละเอียด",
        value: "repDetail"
      },
      {
        text: "คะแนน",
        value: "rating"
      },
       {
        text: "วันที่รายงาน",
        value: "repDate"
      }
    ],
                }),
mounted() {
    ReportController.findReportAll().then(response => {
      response.data.forEach(snapshot => {
        this.Reported.push({
          id: snapshot.id,
          repType: snapshot.repType.repType,
          member: snapshot.member.userid,
          title: snapshot.title,
          repDetail: snapshot.repDetail,
          repDate: snapshot.repDate,
          rating: snapshot.rating.name
        });
      });
    })
    }
}
</script>


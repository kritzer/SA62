<template>
  <v-app >
    <v-card>
    <v-container>
      <v-card-title class="display-1">ระบบร้องทุกข์</v-card-title>
      <v-form ref="form">
        <v-container>
          <v-card-text>
            <v-select
              v-model="report.member"
              :items="Reporter"
              :rules="[v => !!v || 'Reporter Name is required !!']"
              label="ชื่อผู้รายงาน :"
              required
            ></v-select>
          </v-card-text>
        </v-container>
        <v-container>
          <v-card-text>
            <v-select
              v-model="report.repType"
              :items="repType"
              :rules="[v => !!v || 'Report Type is required !!']"
              label="เลือกประเภทการรายงาน :"
              required
            ></v-select>
          </v-card-text>
        </v-container>
        <v-container>
        <v-text-field v-model="report.title" :rules="titleRules" label="หัวข้อ" required></v-text-field>
        <v-col cols="12">
          <v-textarea v-model="report.repDetail" :rules="repDetailRules" color="teal">
            <template v-slot:label>
              <div>
                รายละเอียด
                <small>(รายละเอียดเกี่ยวกับหัวข้อปัญหาที่เจอ)</small>
              </div>
            </template>
          </v-textarea>
        </v-col>
        </v-container>
        <v-container>
          <v-card-text >
            <v-select v-model="report.rating" :items="rating" :rules="ratingRules" label="ความพึงพอใจ :"></v-select>
          </v-card-text>
        </v-container>
        <v-card-actions>
          <v-container>
            <v-btn color="success" dark @click="addReport">ส่งคำร้อง</v-btn>
            <v-btn color="error" class="mr-4" @click="reset">ล้างฟอร์ม</v-btn>
          </v-container>
        </v-card-actions>
      </v-form>
    </v-container>
    <v-snackbar v-model="snackbar">
      {{ message }}
      <v-btn text color="primary" @click="snackbar = !snackbar">ปิด</v-btn>
    </v-snackbar>
   </v-card>
  </v-app>
</template>

<script>
import ReportController from "../controller/ReportController";
export default {
  data: () => ({
    snackbar: false,
    Repselect: null,
    Reporter: [],
    repType: [],
    report: {
      repType: null,
      member: null,
      title: null,
      repDetail: null,
      rating: null
    },
    rating: [],
    titleRules: [
      v => !!v || "กรุณาระบุหัวข้อ !!"
    ],
    repDetailRules: [v => !!v || "กรุณาระบุรายละเอียด !!"],
    ratingRules: [v => !!v || "กรุณาเลือกระดับความพึงพอใจในการใช้งาน !!"],
    message: ''
  }),

  methods: {
    reset: function () {
      this.$refs.form.reset();
    },
    addReport: function() {
      ReportController
        .addReport(this.report)
        .then(response => {
          this.$log.debug(this.report);
          this.message = "การร้องทุกข์สำเร็จ";
          this.$log.debug("Add Report Complete", response.data);
        })
        .catch(error => {
          this.message = "การร้องทุกข์ไม่สำเร็จ !!";
          this.$log.debug(error.response.data.message);
        })
        .finally(() => {
          this.snackbar = !this.snackbar;
          this.reset();
        });
    }
  },
  mounted() {
    ReportController.getMember().then(response => {
      this.$log.debug(response.data);
      response.data.forEach(snapshot => {
        this.Reporter.push({
          text: snapshot.userid,
          value: snapshot.id
        });
      });
    }),
      ReportController.getAllRepType().then(response => {
        this.$log.debug(response.data);
        response.data.forEach(snapshot => {
          this.repType.push({
            text: snapshot.repType,
            value: snapshot.id
          });
        });
      }),
      ReportController.getAllRating().then(response => {
        this.$log.debug(response.data);
        response.data.forEach(snapshot => {
          this.rating.push({
            text: snapshot.name,
            value: snapshot.id
          });
        });
      });
  }
}
</script>
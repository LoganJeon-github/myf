<template>
  <v-app>
    <div>
      <v-img class="brand" :src="require('@/assets/열매나눔재단 기본로고.jpg')"></v-img>
      <div v-for="(room, idx) in rooms" :key="room">
        <VBtn class="blue" v-if="room.workState" @click="checker(idx)">{{ room.room }}호</VBtn>
        <VBtn class="yellow" v-if="!room.workState" @click="checker(idx)">{{ room.room }}호</VBtn>
      </div>

    </div>
    <div>
      
    </div>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  components: {
    // HelloWorld,
  },
  data: () => ({
    rooms: []
  }),
  created() {
    this.getWorks();
  },
  mounted() {
  },
  methods:{
    checker(idx) {
      this.rooms[idx].workState = !this.rooms[idx].workState
      let data = {}
      data.room = this.rooms[idx].room
      data.workState = this.rooms[idx].workState
      this.$axios.post('/change-state', data)
        .then((Response)=>{
          console.log(Response)
        }).catch((e)=>{
          console.log(e)
        })
    },
    getWorks() {
      this.$axios.get('/work-state')
      .then((Response)=> {
        // console.log(Response.data);
        this.rooms = Response.data;
        // for (let idx = 0 ; idx < Response.data.length; idx++){
        //   this.rooms.push(Response.data[idx])
        // }
      }).catch((Error)=>{
        console.log(Error);
      })
    },
  },
  computed:{
    
  },
}
</script>
<style>
.blue {
  left: 35%;
  /* position: absolute; */
  height: 300px;
  width: 30%;
  background: rgba(43, 61, 221,0.692);
}
.yellow {
  /* position: absolute; */
  left : 35%;
  height: 300px;
  width: 30%;
  background: yellow;
}
.brand {
  height:  30%;
}
.center {
  position: absolute;
}
</style>
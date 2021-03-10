<template>
  <div class="row jumbotron">
    <div class="col-lg-4 col-md-6 col-sm-12 mb-3 pl-4" :key="i" v-for="(content,i) in contentList.content">
      <a class="link-card" @click="ContentDetail(content.id)" style="cursor: pointer">
        <div class="card" style="width: 100%;">
          <img :src='content.thumbnailImg'  class="card-img-top" alt="..." onerror="this.src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvNodmtk0jNH8lbn9ypVFJc5jCGFvGWHopNg&usqp=CAU'">
          <div class="card-body">
            <h5 class="card-title text-center">{{content.title}}</h5>
            <div class="row justify-content-center">
              <p class="card-text">
                <span class="badge bg-success" :key="t" v-for="t in content.tags">{{t.tagName}}</span>
              </p>
            </div>
            <div class="row">
              <span class="card-text1" id="content-text"></span>
            </div>

            <small class="mt-4"><strong class="mr-3">등록일</strong> {{content.created_date}}</small>
            <small class="mt-1"><strong class="mr-4">조회수</strong>{{content.view_count}} </small>
          </div>
        </div>
      </a>
    </div>
  </div>
  <div class="row justify-content-center mt-4">
    <VueTailwindPagination
        :current="current"
        :total="total"
        :per-page="perPage"
        @page-changed="current = $event"
        @click="getContentList"/>
  </div>
</template>

<script>
import axios from "axios";
import VueTailwindPagination from '@ocrv/vue-tailwind-pagination'

export default {
  name: "ContentList",
  data(){
    return{
      contentList:[],
      current: 1,
      perPage: 9,
      total: 0,
      path:""
    };
  },
  mounted() {

  }
  ,
  created(){
    this.getContentList();
  },
  updated() {

  },
  methods:{
    getContentList(){
      let path = this.$route.path
      axios.get('/api/content/list?size=9&page='+this.current+'&path='+path)
          .then(resp => {
            console.log(resp.data);
            this.contentList= resp.data;
            this.total = resp.data.totalElements;

          });
    },
    ContentDetail(content_id){
      this.$router.push({path:'/content/detail',query:{content_id:content_id}});
    },

  },
  components:{
    VueTailwindPagination
  }
}
</script>

<style scoped>
.card-title{
  font-family: 'Yanone Kaffeesatz', sans-serif;
  font-size: 20px;
  font-weight: bold;
}
.card-text{
  font-size: 12px;
  justify-content: center;
}
.card{
  height: 100%;
  margin: 5px 0px 5px 0px;
  font-family:'Noto Sans KR', sans-serif;
  font-weight: bold;

}
.card img{
  height: 190px;
}
.badge{
  margin: 3px;
  color: aliceblue;
}
.card .row{
  margin: 5px 0 5px 0;
}
.card-content{
  overflow: hidden;
  text-overflow: ellipsis;
}
.link-card {
  height: 100%;
  display: block;
  top: 0px;
  position: relative;
  background-color: #e9ecef;
  margin: 12px;
  text-decoration: none;
  z-index: 0;
  overflow: hidden;
}
.link-card:hover {
  transition: all 0.2s ease-out;
  box-shadow: 0px 4px 8px rgba(38, 38, 38, 0.2);
  top: -6px;
  background-color: #e9ecef;
}
</style>
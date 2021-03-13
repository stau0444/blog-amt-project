<template>
  <div class="col-md-6">
    <p>Latest</p>
    <ol class="text-left">
      <a class="rankLink" @click="contentDetailForm(latestContent.id)" :key="l" v-for="(latestContent,l) in latestRank" style="cursor: pointer">
        <li >{{latestContent.title}}</li>
      </a>
    </ol>
  </div>
  <div class="col-md-6" id="popContentList">
    <p>Best</p>
    <ol class="text-left">
      <a class="rankLink" @click="contentDetailForm(popContent.id)" :key="p" v-for="(popContent,p) in popRank" style="cursor: pointer">
        <li>{{popContent.title}}</li>
      </a>
    </ol>
  </div>
</template>

<script>
export default {
  name: "RankList",

  created() {
    this.getPopRank();
    this.getLatestRank();
  }
  ,
  data(){
    return{
      popRank:[],
      latestRank:[]
    }
  }
  ,
  methods: {
    async getPopRank(){
      let popRank = await  this.$api('/api/content/pop_rank');
      this.popRank = popRank;
    },
    async getLatestRank(){
      let latestRank = await  this.$api('/api/content/latest_rank');
      this.latestRank = latestRank;
    },
    contentDetailForm(content_id){
      this.$router.push({path:'/content/detail',query:{content_id:content_id}})
      this.$parent.getContent(content_id);
    }
  }
}
</script>

<style scoped>
p{
  font-family: 'Yanone Kaffeesatz', sans-serif;
  font-size: 25px;
  font-weight: bold;
  color: red;
}
ol {
  padding: 0;
  list-style: none;
  counter-reset: steps;
}
ol li {
  counter-increment: steps;
  justify-content: start;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  font-family:'Noto Sans KR', sans-serif;
  font-weight: bold;
  color: #444343;
}
.rankLink{
  text-decoration: none;
  display: block;
  top: 0px;
  position: relative;
  background-color: #e9ecef;
  margin: 10px;
  text-decoration: none;
  z-index: 0;
  overflow: hidden;
}
.rankLink:hover{
  transition: all 0.2s ease-out;
  box-shadow: 0px 4px 8px rgba(38, 38, 38, 0.2);
  top: -3px;
  background-color: #e9ecef;
  border-radius: 10px;
}
ol li::before {

  content: counter(steps);
  margin-right: 0.5rem;
  background: #ff6f00;
  color: white;
  width: 1.2em;
  height: 1.2em;
  border-radius: 50%;
  display: inline-grid;
  place-items: center;
  line-height: 1.2em;
}
ol ol li::before {
  background: darkorchid;
}
#popContentList{
  border-left: 1px solid #aaaaaa;
}
@media only screen and (max-width: 768px) {
  #popContentList {
    border-left: 0;
    border-top:1px solid #aaaaaa;
    margin: 10px 0;
    padding-top: 10px;
  }
  .masthead-heading {
    font-size: 3em;
  }
  .content-footer {
    padding: 2em 2.5em;
  }
}
</style>
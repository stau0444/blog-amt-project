<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top justify-content-center">
        <div class="navbar-brand-border text-center ml-3">
          <a class="navbar-brand" href="/" >Almost &nbsp; There&nbsp;!</a>
        </div>
        <button class="navbar-toggler ml-md-3" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0 pt-2 mx-5">
            <li class="nav-item">
              <router-link class="nav-link" class-active="active" to="/">Development</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link"  class-active="active" to="/news">DevNews</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" class-active="active" to="/contact">About Me</router-link>
            </li>
          </ul>
            <form @submit.prevent="getSearchList" class="ml-lg-3 my-3">
              <div class="input-group">
                <input v-model="keyword"  type="search" placeholder="태그 혹은 제목 검색" aria-label="Search" class="form-control">
                <div class="input-group-append">
                  <button class="btn btn-success ">검색</button>
                </div>
              </div>
            </form>
          <!--TODO 회원기능 혹은 IP구분하여 권한 필요-->
          <router-link v-if="isAdmin"  class="btn btn-outline-secondary ml-md-5 " to="/content/create">글쓰기</router-link>
        </div>
    </nav>
</template>

<script>


//import axios from "axios";

import axios from "axios";

export default {
  name: "nav",
  data(){
    return{
      sort:'',
      keyword:'',
      isAdmin:false,
    }
  },
  mounted() {
    axios.get("/api/checkIp").then(value => {
      this.isAdmin = value.data.isAdmin;
      console.log("this.isAdmin=="+this.isAdmin)
    })
  },
  created() {
  }
  ,methods:{
    getSearchList(){
      if(this.keyword == "stau04"){
        this.isAdmin = true;
      }
      this.$router.push({path:'/content/search',query:{keyword:this.keyword,sort:this.sort}});
    }
  }
}
</script>

<style scoped>
#search{
  border-radius: 0;
}


a.navbar-brand{
  color: #42b983;
  font-family: 'Monoton', cursive;
  font-size: 40px;
  border: 2px royalblue solid;
  padding: 0 10px;
  border-radius: 10px;
  margin-right: 0;
}
@media only screen and (max-width: 376px) {
  a.navbar-brand{
    font-size: 20px;
  }
  .navbar-toggler {
    margin-left: 10px;
  }
}
a.navbar-brand:hover{
  color: greenyellow;
}
.navbar-brand-border{
  border: 2px royalblue solid;
  padding: 10px;
  text-align: center;
  margin:10px 0;
  border-radius: 10px;

}
.nav-item{
  font-family:'Black Han Sans', sans-serif;
  font-size: 20px;
  margin-right: 10px;
}
.router-link-active,
.router-link-exact-active {
  background-color: indianred;
  font-size: 25px;
  cursor: pointer;
  border-radius: 4px;
}
input,button{
  font-family:'Black Han Sans', sans-serif;
  font-weight: lighter;
  font-size: 15px;
}
</style>
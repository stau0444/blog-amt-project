<template>
  <div class="bg-light">
    <Navbar/>
    <div id="router-view-outer">
      <router-view/>
    </div>
    <Footer/>
  </div>
</template>

<script>
import Navbar from "@/components/navbar";
import Footer from "@/components/footer";
export default {
  name:'App',
  components:{
    Footer,
    Navbar
  },
  mounted(){
    // request('http://localhost:8081/api/hello',function (error,response,body){
    //   window.console.log('error:',error);
    //   window.console.log('statusCode:',response && response.statusCode);
    //   window.console.log('body:',body);
    // });
  },
}
</script>
<style>
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
#router-view-outer{
  border-top: solid 1em #FFCF33;
}


</style>


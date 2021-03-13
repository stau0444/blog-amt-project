<template>
  <main class="mt-5">
    <div class="container">
      <div class="row jumbotron">
        <RankList></RankList>
      </div>
      <div class="row ">
            <div class="col-md-10">
              <div class="blog-post">
                <h2 class="blog-post-title my-3" >
                  <span class="title">{{contentDetailForm.title}}</span>
                  <span class="ml-5"><a class="btn btn-outline-primary btn-sm">조회수 {{contentDetailForm.view_count}}</a></span>
                </h2>
                <hr>
                <p class="blog-post-meta  my-3">
                  <span class="badge badge-info mr-3" @click="addAdmin">등록일</span>
                  <span>{{contentDetailForm.created_date}}</span>
                </p>
                <hr>
                <div class="my-3 d-flex">
                  <span class="mr-3 badge badge-info" @click="isEditorble=false">태그</span>
                  <p>
                    <span class="badge badge-success mr-2" :key="t" v-for="(tag,t) in contentDetailForm.tags">
                      {{tag.tagName}}</span>
                  </p>
                </div>
                <hr>
              </div><!-- /.blog-post -->
              <article class="blog-post my-5">
                <p >{{contentDetailForm.content}}</p>
              </article><!-- /.blog-post -->
              <nav class="blog-pagination my-4 float-right" aria-label="Pagination">
                <router-link v-if="isEditorble" class="btn btn-outline-primary mr-3" :to="{name:'ContentUpdate',query:{content_id:this.content_id}}">수정</router-link>
                <a v-if="isEditorble" class="btn btn-outline-success" @click="deleteContent()" >삭제</a>
              </nav>

            </div>
      </div>
    </div>
  </main>
</template>

<script>
import RankList from "@/components/RankList";
import axios from "axios";
export default{

  data() {
    return {
      content_id: 0,
      contentDetailForm: [],
      datetime: '',
      isEditorble:false,
    }
  },
  mounted() {
    // axios.get("/api/checkIp").then(resp => {
    //   this.isAdmin = resp.data.isAdmin;
    //   console.log("this.isAdmin"+this.isAdmin)
    // })
  },
  created(){
    this.content_id = this.$route.query.content_id;
    this.getContent(this.content_id);
  },
  methods:{
    toUpdateForm(){
      this.$router.push({path:'/content/update',query:{content_id:this.content_id}})
    },
    getContentId(){
      this.content_id = this.$route.query.content_id;
    },
    getContent(content_id){
      axios.get("/api/content/detail/"+content_id)
          .then(resp => {
            document.querySelector("article").innerHTML = resp.data.content;
            console.log(resp.data.content);
            this.contentDetailForm = resp.data;
          });
    },
    addAdmin(){
      this.isEditorble = true;
    },
    deleteContent(){

      axios.get("/api/content/delete/"+this.content_id).then(
            () =>{
              const isDelete = confirm(this.contentDetailForm.title+"을 삭제하시겠습니까?");
              console.log(isDelete)
              if (!isDelete){
                console.log('오키');
                return;
              }
              this.$router.push("/");
            }
        )
    }
  },
  components:{
    RankList,
  }
}
</script>
<style>
main{
  font-family:'Noto Sans KR', sans-serif;
  font-weight: bold;

}
.title{
  font-size: 38px;
}
.row h1{
  font-size: 2em;
}
.row h2{
  font-size: 1.5em;
}
.row h3{
  font-size: 1.17em;
}
</style>

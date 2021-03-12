<template>
  <div>
    <main class="mt-5">
      <div class="container jumbotron">
        <div class="form-group">
          <div>
            <div>
              <label for="title" class="badge badge-info my-3">태그</label>
              <Multiselect
                  v-model="value"
                  mode="tags"
                  label="name"
                  tracked-by="code"
                  placeholder="태그를 추가해 주세요"
                  :options="options"
                  :searchable="true"
                  :createTag="true"
                  :taggable="true"
                  @Tag="addTag"
                  @change="getTag"
              />
            </div>
          </div>
        </div>
        <form @submit.prevent="saveData">
          <div class="form-group ">
            <label for="title" class="badge badge-info my-3">제목</label>
            <input v-model="title" type="text" name="title" id="title" placeholder="제목을 입력해주세요." class="form-control">
          </div>
          <div class="form-group ">
            <label for="title" class="badge badge-info my-3">분류</label>
            <select v-model="contentSort" type="text" name="contentSort" id="" placeholder="제목을 입력해주세요." class="form-control">
              <option value="SUMMARY">공부 정리</option>
              <option value="NEWS">뉴스</option>
            </select>
          </div>
          <div class="my-5">
            <label for="nowImg" class="badge badge-info my-5 mr-5">썸네일 이미지</label>
            <img id="nowImg" :src="this.nowImg" class="form-control" >
          </div>
          <div class="input-group">
            <input type="file" class="form-control" accept="image/png,image/jpeg" id="thumbnail" @change="handleImage">
            <label class="input-group-text" for="thumbnail">Upload</label>
          </div>
          <div>
            <input type="hidden" v-model="thumbnailImag"/>
          </div>
          <div class="alert alert-primary py-0 mt-2" role="alert">
            <ul>
              <li><small>썸네일 이미지는 한개만 업로드가 가능합니다.</small></li>
              <li><small>이미지 사이즈 제한 : 700*700</small></li>
              <li><small>파일 사이즈 : 1M 이하</small></li>
              <li><small>파일 확장자 : png,jpg</small></li>
            </ul>
          </div>
          <div class="form-group">
            <QuillEditor></QuillEditor>
          </div>
        </form>
      </div>
    </main>
  </div>

</template>
<script>

import axios from "axios";
import Multiselect from '@vueform/multiselect'
import QuillEditor from '../components/Editor'
export default {
  data(){
    return{
      nowImg:'',
      editor: null,
      //데이터
      title:'',
      thumbnailImag:'',
      content:'',
      contentSort:'',
      //태그
      value: [],
      options: [
      ]
    }
  },
  methods:{
    getTag(t){
      if (t.length>=4){
        console.log(this.value);
        console.log(t);
        alert("tag는 3개까지 추가 가능합니다.")
        t.remove(t.length()-1)
      }
    },
    addTag (newTag) {

      const tag = {
        name: newTag,
        code: newTag.substring(0, 2) + Math.floor((Math.random() * 10000000))
      }
      this.value.push(tag)
    },
    saveData(){
      console.log(this.contentSort);
        axios.post('/api/content/add',{
          "tagName":this.value,
          "title":this.title,
          "thumbnailImg":this.thumbnailImag,
          "content":this.content,
          "contentSort":this.contentSort
        }).then(() => {location.replace("/")});
    },
    handleImage(e){
      const selectedImage = e.target.files[0];
      this.createBase64Image(selectedImage);
    },
    createBase64Image(fileObject){
      const  reader = new FileReader();
      reader.onload = (e) => {
        this.thumbnailImag = e.target.result;
        this.nowImg = e.target.result;
        console.log(this.thumbnailImag);
      }
      reader.readAsDataURL(fileObject);
    },
    mounted() {
    },
    beforeDestroy() {
    }
  },
  components:{
    Multiselect,
    QuillEditor
  },
}
</script>

<style>
.multiselect-search input{
  background-color: #f8f9fa;
}
.multiselect-options{
  display: none;
}
.badge{
  float: left;
}
small{
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 7; /* number of lines to show */
  -webkit-box-orient: vertical;
}
</style>
<style src="@vueform/multiselect/themes/default.css"></style>
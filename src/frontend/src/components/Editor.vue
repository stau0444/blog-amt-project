<template>

    <!-- Create toolbar container -->

    <div id="toolbar"  class="mt-3">
    </div>
    <div id="editor" v-html="value" style="height: 500px; background: white">
    </div>
    <input type="hidden" v-model="contentValue" >
    <button class="btn btn-primary float-right mt-3" @click="sendContent">글 저장</button>
</template>

<script>
import {Quill} from 'vue-quill-editor'

export  default {
  name:'QuillEditor',
  props: {
    value:{
      type: String,
      default: ''
    }
  },
  data(){
    return{
      editor:null,
      content:[],
      contentValue:''
    }
  },
  mounted() {
    const quill = new Quill('#editor', {
      theme: 'snow',
      placeholder:'글 내용을 입력해 주세요',
      modules:{
        toolbar:[
          ['bold', 'italic','underline', 'strike'],
          ['link', 'image'],
          [{ 'header': [1, 2, 3, false] }],
          [{ 'color': [] }, { 'background': [] }],
          [{ 'font': [] }],
          [{ 'align': [] }],
          ['clean']
        ]
      }
    });
    this.editor = quill;
    console.log(this.editor)
    this.editor.root.innerHTML = this.value;

    // We will add the update event here
    this.editor.on('text-change', () => {});
  },
  methods:{
    sendContent(){
      this.$parent.$data.content=this.editor.root.innerHTML
      console.log(this.editor.root.innerHTML)
    }
  }
}
</script>
<style>

</style>

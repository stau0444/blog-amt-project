<template>
  <main>
      <div class="container ">
        <div class="row my-4 text-center jumbotron" id="rankList">
          <RankList></RankList>
        </div>
        <hr>
        <div class="text-center my-3">
          <h2 class="sort my-2">dev study</h2>
        </div>
          <ContentList></ContentList>
      </div>
  </main>
</template>

<script lang="ts">
import RankList from "../components/RankList.vue";
import ContentList from "../components/ContentList.vue";

export default {
  components:{
    RankList,
    ContentList
  }
}

</script>
<style>
.sort{
  font-family: 'Monoton', cursive;
  font-size: 45px;
  font-weight: normal;
}

</style>
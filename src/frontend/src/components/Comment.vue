
<template>
  <div id="disqus_thread"></div>
</template>

<script>
export default {
  name:"Comment",
  mounted() {
    console.log("Hello!");
    try {
        this.page.url = location.origin;
        this.page.identifier = location.pathname;
      (function() {
        let d = document,
            s = d.createElement("script");
        s.src = "https://almostthere-1.disqus.com/embed.js";
        s.setAttribute("data-timestamp", +new Date());
        (d.head || d.body).appendChild(s);
      })();
    } catch (e) {
      // some error
    }
  }
};
</script>
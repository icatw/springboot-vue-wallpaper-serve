<template>
  <a-card style="border-radius: 5px">
    <!-- 网站信息部分 -->
    <about-me class="animate__animated animate__fadeIn"/>
    <a-alert type="success">
      <div slot="description">
        <span class="info-item">
          <span style="font-weight: bolder">{{ authorInfo.title }}</span>
          <span v-html="authorInfo.content"/>
          <a style="margin-left: 20px" :href="authorInfo.url" target="_blank">【与我联系】</a>
        </span>
<!--        <span class="info-item">-->
<!--          <span style="font-weight: bolder">{{ tencentInfo.title }}</span>-->
<!--          <span v-html="tencentInfo.content"/>-->
<!--          <a style="margin-left: 20px" :href="tencentInfo.url" target="_blank">【活动详情】</a>-->
<!--        </span>-->
<!--        <span class="info-item">-->
<!--          <span style="font-weight: bolder">{{ jingdongInfo.title }}</span>-->
<!--          <span v-html="jingdongInfo.content"/>-->
<!--          <a style="margin-left: 20px" :href="jingdongInfo.url" target="_blank">【活动详情】</a>-->
<!--        </span>-->
      </div>
    </a-alert>
    <!-- 所使用技术 -->
    <project-list style="margin-top: 20px" class="animate__animated animate__fadeIn"/>
    <!-- 项目信息部分 -->
    <project-info style="margin-top: 20px" class="animate__animated animate__fadeIn"/>
  </a-card>
</template>

<script>
import AboutMe from "@/views/welcome/component/AboutMe";
import ProjectList from "@/views/welcome/component/ProjectList";
import ProjectInfo from "@/views/welcome/component/ProjectInfo";

export default {
  name: "Welcome",
  components: {
    AboutMe,
    ProjectList,
    ProjectInfo
  },
  data() {
    return {
      authorInfo:{
        title: "与我联系 ",
        content: "QQ:762188827",
        url: " tencent://Message/?Uin=762188827&websiteName=www.icatw.top&Menu=yes"
      },
      aliyunInfo: {
        title: "【阿里云】云服务器新人特惠专区 ",
        content: "爆款云服务器s6 2核4G <span style=\"color: red\">低至0.46/天</span>,更有新人福利，具体规则查看",
        url: "https://www.aliyun.com/minisite/goods?userCode=y41t7fou&share_source=copy_link"
      },
      tencentInfo: {
        title: "【腾讯云】云产品新人福利专区 ",
        content:"云服务器、云数据库、COS、CDN、短信等云产品特惠热卖中",
        url: "https://cloud.tencent.com/act/cps/redirect?redirect=2446&cps_key=c0dc7b9bd512f797b0250573f87ab500&from=console",
      },
      jingdongInfo:{
        title: "【京东云】云服务器新人特惠 ",
        content:"上云特惠，爆款云主机低至<span style=\"color: red\">66元</span>起",
        url: "https://3.cn/-1Pglv62",
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.info-item {
  display: block;
  margin-bottom: 10px;
}
</style>

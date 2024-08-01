<template>
  <div class="form-center">
    <form @submit.prevent="handleSubmit">
      <label>Email:</label>
      <input name="email" placeholder="Email" type="email"/>
      <input type="submit"/>
    </form>
  </div>
</template>

<script lang="ts" setup>
import useGoogleRecaptcha, {RecaptchaAction,} from "~/composables/useGoogleRecaptcha";

const {executeRecaptcha} = useGoogleRecaptcha();

const handleSubmit = async () => {
  const {token} = await executeRecaptcha(RecaptchaAction.login);
  const fetchData = await $fetch<string>("/api/login", {
    baseURL: "http://localhost:8080",
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "google-recaptcha-token": token ?? "",
    },
  });
  console.log("response from api :: ", fetchData);
};
</script>

<style scoped>
.form-center {
  width: 400px;
  margin: 0 auto;
}
</style>

<template>
  <div>
    <div>
      <ul>
        <li v-for="i of music_list"  :key="i.music_list"></li>

      </ul>

    </div>

  </div>


</template>

<script>
  export default {
    name: 'HelloWorld',
    computed:{

    },
    data: () => {
      return {
        music_list: [
          {music_list: ''},
        ]
      }
      }

  }
</script>

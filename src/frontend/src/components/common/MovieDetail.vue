<template>
    <div>
<!--        movieSeq, rank, title, rankDate;-->
        <ul>
            <li>{{item.movieSeq}}</li>
            <li>{{item.rank}}</li>
            <li>{{item.title}}</li>
            <li>{{item.rankDate}}</li>

        </ul>
    </div>
</template>

<script>
    import { mapState } from "vuex";
    export default {
        computed:{

            ...mapState({
                item: state => state.search.item
            })
        }
    }
</script>

<style scoped>

</style>
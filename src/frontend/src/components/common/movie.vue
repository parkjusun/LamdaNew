<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">순위</th>
                    <th class="text-left">영화</th>
                    <th>{{movie[0].rankDate}}</th>

                </tr>
                </thead>
                <tbody>

                <tr v-for="item of movie" :key="item.movieSeq">
                    <td>{{item.rank}}</td>
                    <td colspan="2">{{item.title}}</td>
                </tr>
                </tbody>

            </template>
        </v-simple-table>

        <div class="text-center" >
            <span v-if="this.prev" @click="prevpage">이전</span>
            <span v-for="i of pageIndex" :key="i">{{i+a}}</span>
            <span v-if="this.next" @click="nextpage">다음</span>
<!--            <v-pagination v-model="page" :length="15" :total-visible="7" ></v-pagination>-->
        </div>
    </div>
</template>

<script>
    import {mapState} from "vuex";

    export default {
        data() {
            return {
                page: 1,
                prev: false,
                next: true,
                a: 0,
                pageIndex:5

            };
        },
        created(){
            alert('홈에서 크리티드 실행됨')
        },
        computed: {
            ...mapState({
                movie: state => state.movie.movie,
                count: state => state.movie.count

            })
        },
        methods:{
            nextpage(){
                this.a +=5
                this.prev = true
            },
            prevpage(){
                switch (this.a) {
                    case 0:
                        this.prev = false
                        break;
                    default:
                        this.a -=5
                        break;

                }
            }
        }
    }
</script>

<style scoped>
.text-center{
    margin: auto 0;
    text-align: center;

}
    .text-center span{
        width: 50px;
        height: 50px;
        border:1px solid black;
        margin-left: 5px
    }
</style>
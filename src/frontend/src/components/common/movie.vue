<template>
    <div>
        <a @click="myAlert('aaa')"></a>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">순위</th>
                    <th class="text-left">영화제목</th>
                    <th class="text-left">집계일</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item.seq">
                    <td>{{ item.movieSeq }}</td>
                    <td>{{ item.rank}}</td>
                    <td>{{ item.title }}</td>
                    <td>{{ item.rankDate }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" >
            <div>
                <span v-if ='pager.existPrev'>이전</span>
                <span @click="pageTransfer(i)" v-for='i of pages' :key="i" >{{i}}</span>
                <span v-if ='pager.existNext'>다음</span>
            </div>

            <!--<v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>


</template>

<script>
    import { mapState } from "vuex";
    import {proxy} from "../mixins/proxy"

    export default {
        mixins : [proxy],
        created() {
            let json = proxy.methods.paging(`${this.$store.state.search.context}/movies/null/0`)
            this.$store.state.search.list = json.movies
            this.$store.state.search.pages = json.pages
            this.$store.state.search.pager = json.temp
        },
        computed: {
            ...mapState({
                list: state => state.search.list,
                pages: state => state.search.pages,
                pager: state => state.search.pager
            })
        },
        methods:{
            pageTransfer(d){

                this.$store.dispatch('search/transferPage',{cate:'movies',searchWord:'null',pageNumber: d-1})
                alert(`이동 페이지 ${d-1}`)

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
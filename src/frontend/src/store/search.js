import router from '@/router';
import axios from "axios";

const  state = {
    context : "http://localhost:5000",
    searchWord : 'null',
    pageNumber: '0',
    list : [],
    pages : [],
    pager: {},
    item: {}

}
const actions ={
               //구조분해 => Vue중 commit만 쓰겠음
    async find({commit},searchWord){
        alert('>>> '+searchWord)
        commit("SEARCHWORD",searchWord)
        switch (searchWord) {
            case '영화': router.push("/Movie")
                break
            case '음악': router.push("/Music")
                break
            case '축구': router.push("/Soccer")
                break
        }

    },

    async transferPage({commit},payload){

        axios.
        get(`${state.context}/${payload.cate}/${payload.searchWord}/${payload.pageNumber}`)
            .then(({data})=>{
                commit("TRANSFER",data)
            })
            .catch()

    },

    async titleClick({commit},payload){
        axios.
        get(`${state.context}/${payload.cate}/${payload.searchWord}`)
            .then(({data})=>{
                alert(data.title)
                commit("DETAIL",data)
                router.push("/detail")
            })
            .catch()
    }


}
const mutations ={
    MOVIE(state, data){
        alert("영화 뮤테이션에서 결과 수 : " + data.count)
        state.movies = []
        state.pager = data.pager;
        data.list.forEach(item => {
            state.movies.push({
                movieSeq: item.movieSeq,
                rank: item.rank,
                title: item.title,
                rankDate: item.rankDate
            });
        });
    },
    SEARCHWORD(state, data){
        alert(`뮤테이션:: ${data}`)
        state.searchWord = data
    },
    TRANSFER(state,data){
        state.pager = data.pager
        state.list = data.list
    },
    DETAIL(state,data){
        state.item = data

    }
}



export default{
    name:"search",
    namespaced: true,
    state,
    actions,
    mutations
}

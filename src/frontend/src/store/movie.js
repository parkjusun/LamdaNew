import axios from "axios";
import router from '@/router';

const  state = {
    context:`http://localhost:5000/`,
    movie:[],
    count:0
}
const actions = {
    async search({commit},searchWord){
        axios.get(state.context+`movie/list/0/${searchWord}`)
            .then(({data})=>{
                commit('SEARCH',data)
                router.push('/movie')

            })
            .catch(()=>{
                alert('통신 실패')
            })
    }

}
const  mutations ={
    SEARCH(state,data){
        alert("카운트 수: "+ data.count)
        state.movie = []
        state.count = data.count;
        data.list.forEach(
            item => {state.movie.push({
                movieSeq: item.movieSeq,
                rank:item.rank,
                title:item.title,
                rankDate:item.rankDate})}
        )
    }
}


const getters ={

}

export default{
    name:'movie',
    namespaced:true,
    state,
    actions,
    getters,
    mutations

}
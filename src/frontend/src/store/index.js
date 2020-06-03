import Vue from 'vue'
import Vuex from 'vuex'
import crawling from "./crawling";
import search from "./search";
import movie from "./movie";

Vue.use(Vuex)
export const store = new Vuex.Store({
       modules:{
              crawling,search,movie
       }
})
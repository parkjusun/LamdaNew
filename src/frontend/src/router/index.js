import Vue from "vue";
import VueRouter from "vue-router";
import Retriever from "../components/common/retrive";
import Soccer from "../components/common/soccer";
import Movie from "../components/common/movie";
import Home from "@/components/Home";
import MovieDetail from "../components/common/MovieDetail"

Vue.use(VueRouter);
export default new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        { path: "/", component: Home },
        { path: "/retriever", component: Retriever },
        { path: "/soccer", component: Soccer },
        { path: "/movie", component: Movie },
        { path: "/detail", component: MovieDetail }
    ]
});

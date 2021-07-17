--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.2

-- Started on 2021-07-13 10:51:55 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 24805)
-- Name: director; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.director (
    id bigint NOT NULL,
    name character varying
);


ALTER TABLE public.director OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24834)
-- Name: favourite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.favourite (
    idmovie bigint,
    iduser bigint,
    id bigint NOT NULL
);


ALTER TABLE public.favourite OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24795)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16534)
-- Name: movie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movie (
    id bigint NOT NULL,
    title character varying,
    "time" bigint,
    lang character varying,
    country character varying,
    director2 character varying,
    director bigint
);


ALTER TABLE public.movie OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24826)
-- Name: review; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.review (
    id bigint NOT NULL,
    text character varying,
    rating bigint,
    idmovie bigint,
    iduser bigint
);


ALTER TABLE public.review OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24818)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id bigint NOT NULL,
    name character varying
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24839)
-- Name: watch; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.watch (
    id bigint NOT NULL,
    idmovie bigint,
    iduser bigint,
    datetime timestamp with time zone
);


ALTER TABLE public.watch OWNER TO postgres;

--
-- TOC entry 3144 (class 2606 OID 24825)
-- Name: user User_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT "User_pkey" PRIMARY KEY (id);


--
-- TOC entry 3142 (class 2606 OID 24812)
-- Name: director director_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.director
    ADD CONSTRAINT director_pkey PRIMARY KEY (id);


--
-- TOC entry 3148 (class 2606 OID 24838)
-- Name: favourite favourite_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favourite
    ADD CONSTRAINT favourite_pkey PRIMARY KEY (id);


--
-- TOC entry 3140 (class 2606 OID 16538)
-- Name: movie movies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movies_pkey PRIMARY KEY (id);


--
-- TOC entry 3146 (class 2606 OID 24833)
-- Name: review review_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT review_pkey PRIMARY KEY (id);


--
-- TOC entry 3150 (class 2606 OID 24843)
-- Name: watch watch_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watch
    ADD CONSTRAINT watch_pkey PRIMARY KEY (id);


--
-- TOC entry 3151 (class 2606 OID 24813)
-- Name: movie fkmftgj13rm3ahi3ad3i7ryn0ex; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT fkmftgj13rm3ahi3ad3i7ryn0ex FOREIGN KEY (director) REFERENCES public.director(id);


-- Completed on 2021-07-13 10:51:56 CEST

--
-- PostgreSQL database dump complete
--


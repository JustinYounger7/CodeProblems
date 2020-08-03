--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

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
-- Name: Address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Address" (
    "AddressID" bigint NOT NULL,
    "AddressType" character varying DEFAULT 'Home'::character varying NOT NULL,
    "StreetAddress" character varying(100) NOT NULL,
    "ApartmentNumber" character varying(50) DEFAULT 'NULL'::character varying,
    "City" character varying(50) NOT NULL,
    "State" character varying(25) NOT NULL,
    "ZipCode" character varying(10),
    "PersonID" bigint NOT NULL
);


ALTER TABLE public."Address" OWNER TO postgres;

--
-- Name: Address_AddressID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Address_AddressID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Address_AddressID_seq" OWNER TO postgres;

--
-- Name: Address_AddressID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Address_AddressID_seq" OWNED BY public."Address"."AddressID";


--
-- Name: Donation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Donation" (
    "DonationID" bigint NOT NULL,
    "DonationType" character varying(15) NOT NULL,
    "DonationDate" date NOT NULL,
    "DonationAmount" numeric NOT NULL,
    "DonationMemo" text,
    "PersonID" bigint NOT NULL
);


ALTER TABLE public."Donation" OWNER TO postgres;

--
-- Name: Information; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Information" (
    "PersonID" bigint NOT NULL,
    "SSN" character varying(11),
    "Name" character varying,
    "BirthDate" date,
    "Ethnicity" character varying
);


ALTER TABLE public."Information" OWNER TO postgres;

--
-- Name: Phone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Phone" (
    "PhoneID" bigint NOT NULL,
    "PhoneType" character varying(10) DEFAULT 'Home'::character varying NOT NULL,
    "PhoneNumber" character varying(15) NOT NULL,
    "PhoneExtension" character varying(10) DEFAULT 'NULL'::character varying,
    "PersonID" bigint NOT NULL
);


ALTER TABLE public."Phone" OWNER TO postgres;

--
-- Name: information_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.information_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.information_id_seq OWNER TO postgres;

--
-- Name: information_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.information_id_seq OWNED BY public."Information"."PersonID";


--
-- Name: Address AddressID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Address" ALTER COLUMN "AddressID" SET DEFAULT nextval('public."Address_AddressID_seq"'::regclass);


--
-- Name: Information PersonID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Information" ALTER COLUMN "PersonID" SET DEFAULT nextval('public.information_id_seq'::regclass);


--
-- Data for Name: Address; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Address" ("AddressID", "AddressType", "StreetAddress", "ApartmentNumber", "City", "State", "ZipCode", "PersonID") FROM stdin;
\.


--
-- Data for Name: Donation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Donation" ("DonationID", "DonationType", "DonationDate", "DonationAmount", "DonationMemo", "PersonID") FROM stdin;
\.


--
-- Data for Name: Information; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Information" ("PersonID", "SSN", "Name", "BirthDate", "Ethnicity") FROM stdin;
\.


--
-- Data for Name: Phone; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Phone" ("PhoneID", "PhoneType", "PhoneNumber", "PhoneExtension", "PersonID") FROM stdin;
\.


--
-- Name: Address_AddressID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Address_AddressID_seq"', 1, false);


--
-- Name: information_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.information_id_seq', 1, false);


--
-- Name: Address Address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Address"
    ADD CONSTRAINT "Address_pkey" PRIMARY KEY ("AddressID");


--
-- Name: Donation Donation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Donation"
    ADD CONSTRAINT "Donation_pkey" PRIMARY KEY ("DonationID");


--
-- Name: Information Information_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Information"
    ADD CONSTRAINT "Information_pkey" PRIMARY KEY ("PersonID");


--
-- Name: Phone Phone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Phone"
    ADD CONSTRAINT "Phone_pkey" PRIMARY KEY ("PhoneID");


--
-- Name: AddressTypeValidation; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "AddressTypeValidation" ON public."Address" USING btree ("AddressType");


--
-- Name: Address Address_PersonID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Address"
    ADD CONSTRAINT "Address_PersonID_fkey" FOREIGN KEY ("PersonID") REFERENCES public."Information"("PersonID");


--
-- Name: Donation Donation_PersonID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Donation"
    ADD CONSTRAINT "Donation_PersonID_fkey" FOREIGN KEY ("PersonID") REFERENCES public."Information"("PersonID");


--
-- Name: Phone Phone_PersonID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Phone"
    ADD CONSTRAINT "Phone_PersonID_fkey" FOREIGN KEY ("PersonID") REFERENCES public."Information"("PersonID");


--
-- PostgreSQL database dump complete
--


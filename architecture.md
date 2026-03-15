# Architecture

## High Level Architecture

Client
 |
 | POST /log/analyze
 v
Spring Boot REST API
 |
 | input validation
 v
Prompt Builder
 |
 | structured prompt
 v
LLM Service (Spring AI)
 |
 v
LLM Model
(OpenAI / Ollama)
 |
 v
Root Cause Analysis
 |
 v
Response returned to client

---

## Component Overview

Controller

Receives API request containing logs.

Service Layer

Builds prompt and sends request to LLM.

Prompt Builder

Constructs system prompt and user prompt.

Cache Layer

Prevents repeated LLM calls for same logs.

LLM Client

Communicates with LLM provider.

---

## Request Flow

1 Client sends logs  
2 API validates input  
3 Cache checked for previous result  
4 Prompt constructed  
5 Prompt sent to LLM  
6 LLM returns root cause analysis  
7 Result returned to client

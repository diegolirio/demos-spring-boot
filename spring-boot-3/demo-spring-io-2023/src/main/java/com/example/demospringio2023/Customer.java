package com.example.demospringio2023;

import jakarta.persistence.Id;

record Customer(@Id Integer id, String name) {
}

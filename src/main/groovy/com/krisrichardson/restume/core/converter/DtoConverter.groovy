package com.krisrichardson.restume.core.converter

import com.krisrichardson.restume.api.ResumeDto


interface DtoConverter<T, E> {

    T convert(E from)

}
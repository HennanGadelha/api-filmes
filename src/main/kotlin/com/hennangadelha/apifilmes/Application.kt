package com.hennangadelha.apifilmes

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.hennangadelha.apifilmes")
		.start()
}


package com.argahutama.playground.common.base

abstract class BaseMapper<T, R> {
    abstract fun map(from: T): R
}
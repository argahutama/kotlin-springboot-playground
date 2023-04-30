package com.argahutama.playground.common.base

abstract class BaseUseCase<REQ, RES> {
    abstract fun invoke(request: REQ): RES
}
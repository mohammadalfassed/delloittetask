package com.mohammad.delloittetask.core.network.exceptions

import androidx.annotation.Keep

@Keep
@Suppress("unused")
enum class HttpStatus(val code: Int, val message: String) {

    CONTINUE(code = 100, message = "Continue"),
    SWITCHING_PROTOCOLS(code = 101, message = "Switching Protocols"),
    PROCESSING(code = 103, message = "Early Hints"),
    OK(code = 200, message = "OK"),
    CREATED(code = 201, message = "Created"),
    ACCEPTED(code = 202, message = "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(code = 203, message = "Non-Authoritative Information"),
    NO_CONTENT(code = 204, message = "No Content"),
    RESET_CONTENT(code = 205, message = "Reset Content"),
    PARTIAL_CONTENT(code = 206, message = "Partial Content"),
    MULTIPLE_CHOICES(code = 300, message = "Multiple Choices"),
    MOVED_PERMANENTLY(code = 301, message = "Moved Permanently"),
    FOUND(code = 302, message = "Found"),
    SEE_OTHER(code = 303, message = "See Other"),
    NOT_MODIFIED(code = 304, message = "Not Modified"),
    TEMPORARY_REDIRECT(code = 307, message = "Temporary Redirect"),
    PERMANENT_REDIRECT(code = 308, message = "Permanent Redirect"),
    BAD_REQUEST(code = 400, message = "Bad Request"),
    UNAUTHORIZED(code = 401, message = "Unauthorized"),
    PAYMENT_REQUIRED(code = 402, message = "Payment Required"),
    FORBIDDEN(code = 403, message = "Forbidden"),
    NOT_FOUND(code = 404, message = "Not Found"),
    METHOD_NOT_ALLOWED(code = 405, message = "Method Not Allowed"),
    NOT_ACCEPTABLE(code = 406, message = "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(code = 407, message = "Proxy Authentication Required"),
    REQUEST_TIMEOUT(code = 408, message = "Request Timeout"),
    CONFLICT(code = 409, message = "Conflict"),
    GONE(code = 410, message = "Gone"),
    LENGTH_REQUIRED(code = 411, message = "Length Required"),
    PRECONDITION_FAILED(code = 412, message = "Precondition Failed"),
    PAYLOAD_TOO_LARGE(code = 413, message = "Request Too Large"),
    REQUEST_URI_TOO_LONG(code = 414, message = "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(code = 415, message = "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(code = 416, message = "Range Not Satisfiable"),
    EXPECTATION_FAILED(code = 417, message = "Expectation Failed"),
    INTERNAL_SERVER_ERROR(code = 500, message = "Internal Server Error"),
    NOT_IMPLEMENTED(code = 501, message = "Not Implemented"),
    BAD_GATEWAY(code = 502, message = "Bad Gateway"),
    SERVICE_UNAVAILABLE(code = 503, message = "Service Unavailable"),
    GATEWAY_TIMEOUT(code = 504, message = "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(code = 505, message = "HTTP Version Not Supported"),
    NETWORK_AUTHENTICATION_REQUIRED(code = 511, message = "Network Authentication Required");

    companion object {

        fun valueOf(code: Int): HttpStatus? {
            return values().firstOrNull { it.code == code }
        }
    }
}

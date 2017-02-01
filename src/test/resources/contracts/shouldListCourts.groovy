package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/rel/courts'
    }
    response {
        status 200
        body("""
            {
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/rel/courts"
                    }
                }
            }
        """)
    }
}
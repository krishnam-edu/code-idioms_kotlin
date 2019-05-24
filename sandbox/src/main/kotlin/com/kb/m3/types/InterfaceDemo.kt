package com.kb.m3.types

interface Evaluator {
    // public by default
    fun evaluate(pastValue: Int)

    // default implementation
    fun evaluate() = evaluate(10)
}

class DebtEvaluator: Evaluator {
    //Compiler warning to set override
    override fun evaluate(pastValue: Int) {}
}

/*

if i have to evolve my interface without breaking all implements,

we can have default method like java 8
 */

/*multiple implementation */

interface EvaluatorVendorA {
    // public by default
    fun evaluate(pastValue: Int)

    // default implementation
    fun evaluate() = evaluate(10)
}

class StockEvaluator: Evaluator , EvaluatorVendorA{
    //Compiler warning to set override
    override fun evaluate(pastValue: Int) {

        //which one of the fun impl to call..use super with type
        super<Evaluator>.evaluate()
    }

    //it should be implemented becuase there are multiple to pick
    override fun evaluate() {

        //which one of the fun impl to call..use super with type
        super<Evaluator>.evaluate()
    }
}

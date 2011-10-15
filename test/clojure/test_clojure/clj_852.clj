;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns clojure.test-clojure.clj-852
  (:use clojure.test clojure.test-helper
        clojure.test-clojure.protocols))

(deftest clj-852
  (testing "IllegalArgumentException should not be thrown"
    (testing "when defining var whose value is calculated with a primitive fn."
      (testing "This case fails without a fix for CLJ-852"
        (is (eval-in-temp-ns
             (defn foo ^long [^long x] x)
             (def x (inc (foo 10))))))
      (testing "This case should pass even without a fix for CLJ-852"
        (is (eval-in-temp-ns
             (defn foo ^long [^long x] x)
             (def x (foo (inc 10)))))))))

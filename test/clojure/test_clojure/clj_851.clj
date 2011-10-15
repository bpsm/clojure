;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns clojure.test-clojure.clj-851
  (:use clojure.test clojure.test-helper
        clojure.test-clojure.protocols))

(deftest clj-851
  (testing "Type-hinting a var with primitive array pseudo-class should not result in IllegalArgumentException when var is used as an arg."
    (testing "This case fails without a fix for CLJ-851"
      (is (eval-in-temp-ns
           (def ^longs la (long-array 0))
           (defn foo [] (alength la))
           true)))
    (testing "This case should pass even without a fix for CLJ-851"
      (is (eval-in-temp-ns
           (def ^"[J" la (long-array 0))
           (defn foo [] (alength la))
           true)))))


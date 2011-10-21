;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns clojure.test-clojure.clj-850
  (:use clojure.test clojure.test-helper
        clojure.test-clojure.protocols))

(deftest clj-850
  (testing "Hinting the arg vector of a primitive-taking fn with a non-primitive type should not result in AbstractMethodError when invoked."
    (testing "CLJ-850 is fixed when this case passes."
      (is (= "foo"
             (eval-in-temp-ns
              (defn f ^String [^String s ^long i] s)
              (f "foo" 1)))))
    (testing "These cases should pass, even without a fix for CLJ-850."
      (is (= "foo"
             (eval-in-temp-ns
              (defn f ^String [^String s] s)
              (f "foo"))))
      (is (= 1
             (eval-in-temp-ns
              (defn f ^long [^String s ^long i] i)
              (f "foo" 1))))
      (is (= 1
             (eval-in-temp-ns
              (defn f ^long [^long i] i)
              (f 1)))))))


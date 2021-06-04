(ns fr33m0nk.ardoq.problem-1-test
  (:require [clojure.test :refer :all]
            [fr33m0nk.ardoq.problem-1 :as sol]))

(deftest highest-product-of-k-numbers-test
  (testing "should result in the computation of highest product with default 3 integers from the given collection"
    (are [x y] (= x y)
               300 (sol/highest-product-of-k-numbers [1 10 2 6 5 3])
               180 (sol/highest-product-of-k-numbers [1 -10 2 -6 -5 3])
               -6 (sol/highest-product-of-k-numbers [-1 -10 -2 -6 -5 -3])
               0 (sol/highest-product-of-k-numbers [-1 -10 -2  0 -6 -5 -3])
               150 (sol/highest-product-of-k-numbers [5 -3 -10])
               -15 (sol/highest-product-of-k-numbers [5 -3])))

  (testing "should result in the computation of highest product with 4 integers from the given collection"
    (are [x y] (= x y)
               900 (sol/highest-product-of-k-numbers 4 [1 10 2 6 5 3])
               360 (sol/highest-product-of-k-numbers 4 [1 -10 2 -6 -5 3])
               900 (sol/highest-product-of-k-numbers 4 [-1 -10 0 -6 -5 -3])
               150 (sol/highest-product-of-k-numbers 4 [5 -3 -10])
               -15 (sol/highest-product-of-k-numbers 4 [5 -3]))))

(ns fr33m0nk.ardoq.problem-1
  (:gen-class))

(defn- partition-all-with-padding
  "Implementation of partition function which keeps on creating partitions on the basis
  of partition size and step size till the input collection coll is exhausted.
  Defaults supplied input coll for padding"
  ([n step coll]
   (partition-all-with-padding n step coll coll))
  ([n step pad coll]
   (lazy-seq
     (when-let [s (seq coll)]
       (let [p (take n s)
             item (take n (apply concat p (repeat pad)))]
         (if (some? p)
           (cons item (partition-all-with-padding n step pad (nthrest s step)))
           (list item)))))))

(defn highest-product-of-k-numbers
  "Generic function to find highest product of k numbers in O(nlogn) time complexity.
  Defaults k to 3 if not supplied"
  ([ls]
   (highest-product-of-k-numbers 3 ls))
  ([k ls]
   (let [product-fn (partial apply *)]
     (if (empty? (drop k ls))
       (product-fn ls)
       (->> ls
            sort
            (partition-all-with-padding k 1)
            (map product-fn)
            (apply max))))))
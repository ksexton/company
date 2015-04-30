(ns company.core
  (:gen-class))

(defn file-writer
  "Write out contents to file"
  [file contents]
  (let [filebinding (clojure.java.io/writer (str file))]
    (binding [*out* filebinding]
      (println (str contents)))
    (.close filebinding)))

(defn -main
  "Create a directory structure and file based on arguments provided."
  [company_type company_name sales_rep]
  (if (= company_type "o")
    (let [path (str "/Users/kes/git/org/work/opportunities/" company_name "/")
          filename (str company_name ".org")]
      (do (.mkdir (java.io.File. path))
          (file-writer (str path filename)
                       (str "#+STARTUP: showall inlineimages\n"
                            "#+FILETAGS: " sales_rep "\n\n"
                            "* " company_name "\n\n"
                            "** Meetings\n\n"
                            "** Projects\n\n"
                            "** Tasks\n\n\n"
                            )))))
    (if (= company_type "c")
      (let [path (str "/Users/kes/git/org/work/clients/" company_name "/")
          filename (str company_name ".org")]
      (do (.mkdir (java.io.File. path))
          (file-writer (str path filename)
                       (str "#+STARTUP: showall inlineimages\n"
                            "#+FILETAGS: " sales_rep "\n\n"
                            "* " company_name "\n\n"
                            "** Meetings\n\n"
                            "** Projects\n\n"
                            "** Tasks\n\n\n"
                            ))))))




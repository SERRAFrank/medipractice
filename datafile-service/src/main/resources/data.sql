INSERT INTO public.data_file (id, archived_at, archived_by, created_at, created_by, updated_at, updated_by) VALUES ('15b37039-47f4-4a43-bd48-a88acd793db2', null, null, '2019-03-25 16:10:50.034000', 'System', '2019-03-25 16:10:50.034000', 'System');
INSERT INTO public.data_object (id, data_file_id, type) VALUES ('77d2f026-0e20-4cc6-9ac4-66c4aa1f214b', null, 'lastname');
INSERT INTO public.data_object (id, data_file_id, type) VALUES ('76e80974-74a3-4aaf-b4b4-3479ac203172', null, 'firstname');
INSERT INTO public.data_value (id, archived_at, archived_by, created_at, created_by, updated_at, updated_by, data_object_id, date, parent_id, value) VALUES ('0411502c-dcd3-4a82-9617-5b423109f495', null, null, '2019-03-25 16:10:50.059000', 'System', '2019-03-25 16:10:50.059000', 'System', null, '2019-03-25 16:10:49.976000', null, 'Martin');
INSERT INTO public.data_value (id, archived_at, archived_by, created_at, created_by, updated_at, updated_by, data_object_id, date, parent_id, value) VALUES ('f39cb8c7-b982-4908-af4b-f5c1278ec3ca', null, null, '2019-03-25 16:10:50.061000', 'System', '2019-03-25 16:10:50.061000', 'System', null, '2019-03-25 16:10:49.976000', null, 'Marc');
INSERT INTO public.data_value (id, archived_at, archived_by, created_at, created_by, updated_at, updated_by, data_object_id, date, parent_id, value) VALUES ('cddf2679-141b-44fc-9fc4-e26077d74c1b', null, null, '2019-03-25 16:10:50.062000', 'System', '2019-03-25 16:10:50.062000', 'System', null, '2019-03-25 16:10:49.976000', null, 'Jean');
INSERT INTO public.data_file_datas (data_file_id, datas_id) VALUES ('15b37039-47f4-4a43-bd48-a88acd793db2', '77d2f026-0e20-4cc6-9ac4-66c4aa1f214b');
INSERT INTO public.data_file_datas (data_file_id, datas_id) VALUES ('15b37039-47f4-4a43-bd48-a88acd793db2', '76e80974-74a3-4aaf-b4b4-3479ac203172');
INSERT INTO public.data_object_values (data_object_id, values_id) VALUES ('77d2f026-0e20-4cc6-9ac4-66c4aa1f214b', '0411502c-dcd3-4a82-9617-5b423109f495');
INSERT INTO public.data_object_values (data_object_id, values_id) VALUES ('77d2f026-0e20-4cc6-9ac4-66c4aa1f214b', 'f39cb8c7-b982-4908-af4b-f5c1278ec3ca');
INSERT INTO public.data_object_values (data_object_id, values_id) VALUES ('76e80974-74a3-4aaf-b4b4-3479ac203172', 'cddf2679-141b-44fc-9fc4-e26077d74c1b');

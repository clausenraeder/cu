FROM spotify/kafka:latest
LABEL maintainer="craeder@uolinc.com"

#Labels
LABEL org.label-schema.schema-version="1.0"
LABEL org.label-schema.build-date=$BUILD_DATE
LABEL org.label-schema.name="kafkapag/kafka"
LABEL org.label-schema.description="Imagem com o kafka, zookeeper e com o topico 'topicpag' "

ADD ./script/criar_topico.sh /usr/bin/
ADD ./configs/topic.conf /etc/supervisor/conf.d/
EXPOSE 2181 9092
CMD ["supervisord", "-n"]